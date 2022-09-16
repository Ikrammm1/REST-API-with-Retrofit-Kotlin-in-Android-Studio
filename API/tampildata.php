<?php
$hostname = "localhost";
$db = "uty";
$user = "root";
$pass = "";
$conn = mysqli_connect($hostname, $user, $pass, $db) or die ('tidak terhubung ke database');
$query = mysqli_query($conn, "SELECT mahasiswa.nim, mahasiswa.nama_mahasiswa, prodi.nama_prodi 
	FROM mahasiswa, prodi WHERE mahasiswa.id_prodi = prodi.id_prodi");
$result = array();
while($row = mysqli_fetch_array($query)){
	array_push($result, array(
		'NIM' => $row['nim'],
		'Nama' => $row['nama_mahasiswa'],
		'PRODI' => $row['nama_prodi']
		
	));
}
echo json_encode(
	array('mahasiswa' => $result)
);
?>