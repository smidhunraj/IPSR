<?php
// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();
$filename = 'empdata.json';
$json = file_get_contents($filename); 
//$data = json_decode($json,true);
// remove the ,true so the data is not all converted to arrays
$data = json_decode($json,true);
 $con = new mysqli("localhost", "root", "");
// Now process the array of objects
foreach ( $data as $row ) {
    $name = $row['name'];
        $gender = $row['gender'];
        $designation = $row['designation'];
     $sql =    "INSERT INTO emp(name, gender, designation) VALUES ('$name', '$gender', '$designation')";
  
    $res = mysqli_query($sql,$con);
echo $res;
    if(!$res){
        $result = new stdClass();
        $result->status = false;
        $result->msg = mysql_error();
        echo json_encode($result);
        exit;
    }
}
?>