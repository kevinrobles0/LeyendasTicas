<?php

	include "connecLT.php";

	$row;
	$id;
	$result;
	$conn = request_connection();
	$story_paragraphs = array();
	
	$stmt = mysqli_prepare($conn,'SELECT sp.ParagraphNumber, p.Text FROM paragraphs p INNER JOIN stories_paragraphs sp ON p.Id = sp.Paragraph_Id WHERE sp.Story_Id = ? ORDER BY sp.ParagraphNumber ASC');

//Get paragraph by ID_story	
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
			$story_paragraphs[] = $row;
		}
		print json_encode($story_paragraphs,JSON_UNESCAPED_UNICODE);
		close_connection($conn);
	}

?>