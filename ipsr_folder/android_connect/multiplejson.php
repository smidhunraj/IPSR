<?php
    // open mysql connection
   /*  $host = "localhost";
    $username = "root";
    $password = "";
    $dbname = "employee";
    $con = mysqli_connect($host, $username, $password, $dbname) or die('Error in Connecting: ' . mysqli_error($con)); */
	require_once __DIR__ . '/db_connect.php';
$db = new DB_CONNECT();
    // use prepare statement for insert query
    $st = mysqli_prepare($con, 'INSERT INTO emp(name, gender, designation) VALUES (?, ?, ?)');

    // bind variables to insert query params
    mysqli_stmt_bind_param($st, 'sss', $name, $gender, $designation);

    // read json file
    $filename = 'empdata.json';
    $json = file_get_contents($filename);   

    //convert json object to php associative array
    $data = json_decode($json, true);

    // loop through the array
    foreach ($data as $row) {
        // get the employee details
        $name = $row['name'];
        $gender = $row['gender'];
        $designation = $row['designation'];
        
        // execute insert query
        mysqli_stmt_execute($st);
    }
    
    //close connection
    mysqli_close($con);
?>