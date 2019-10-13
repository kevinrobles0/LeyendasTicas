<?php

	include "connecLT.php";

	$row;
	$id;
	$result;
	$conn = request_connection();
	$story_questions = array();
	
	$stmt = mysqli_prepare($conn,'SELECT q.Id, q.Text FROM questions q INNER JOIN stories_questions sq ON q.Id = sq.Question_Id WHERE sq.Story_Id = ? ORDER BY RAND()');

//Get question by ID_story	
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
			$story_questions[] = $row;
		}
		print json_encode($story_questions,JSON_UNESCAPED_UNICODE);
		close_connection($conn);
	}

?>