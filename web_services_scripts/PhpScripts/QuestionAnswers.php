<?php

	include "connecLT.php";

	$row;
	$id;
	$result;
	$conn = request_connection();
	$story_anwers = array();
	
	$stmt = mysqli_prepare($conn,'SELECT a.Id, a.Text, qa.CorrectAnswer FROM answers a INNER JOIN questions_answers qa ON a.Id = qa.Answer_Id WHERE qa.Question_Id = ? ORDER BY RAND()');

//Get anwers by ID_story	
	if($_GET["id"])
	{
		$id = $_GET["id"];
		mysqli_stmt_bind_param($stmt, 'd', $id);
		mysqli_stmt_execute($stmt);
		$result = mysqli_stmt_get_result($stmt);
		
		if(!$result)
		{
			echo 'MySQL Error: ' . mysqli_error($conn);
			exit;
		}
		
		while($row = mysqli_fetch_assoc($result))
		{
			$story_anwers[] = $row;
		}
		print json_encode($story_anwers,JSON_UNESCAPED_UNICODE);
		close_connection($conn);
	}

?>