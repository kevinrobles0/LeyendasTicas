<?php
	include "connecLT.php";
	
	$row;
	$conn = request_connection();
	$stories = array();
	mysqli_query($conn,"SET NAMES 'utf8'");
	$return_value = mysqli_query($conn,'SELECT Id, Name FROM stories');
	
	if (!$return_value) {
        echo 'MySQL Error: ' . mysqli_error($conn);
        exit;
    }
	
	while($row = mysqli_fetch_assoc($return_value))
	{
		$stories[] = $row;
	}
    print json_encode($stories,JSON_UNESCAPED_UNICODE);
	close_connection($conn);
?>