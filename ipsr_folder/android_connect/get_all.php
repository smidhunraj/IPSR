<?php

/*
 * Following code will list all the products
 */

// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();
$dats1="";
if (isset($_POST['dats'])) 
{
   $dats1 = $_POST['dats'];
	
}


// get all products from products table
$result = mysql_query("SELECT *FROM emp WHERE dats = '$dats1'") or die(mysql_error());

// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["person"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $person = array();
        $person["name"] = $row["name"];
        $person["dats"] = $row["dats"];
        $person["status"] = $row["status"];
      



        // push single product into final response array
        array_push($response["person"], $person);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No products found";

    // echo no users JSON
    echo json_encode($response);
}
?>