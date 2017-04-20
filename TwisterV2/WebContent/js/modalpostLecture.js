$(function() {

	function minus() {
		sd = $("#likep").html();
		df = parseInt(sd, 10);

		$("#likes").css("background-color", "black");
		$("#likep").html(df - 1);
		$("#likes").attr("selectedf", "false");
	}
	function maxus() {
		sd = $("#likep").html();
		df = parseInt(sd, 10);
		$("#likes").attr("selectedf", "true");
		$("#likes").css("background-color", "blue");
		$("#likep").html(df + 1);
	}
	
	function isSelected(idPost,c) {
		minus();
		env.like.removelike({
			id_post : env.messages_list.get(idPost).id
		}, function(d) {
			console.log(d);
			if (!("response" in d)) {
				maxus();
				
			}
			c();
		});

	}
	function isNotSelected(idPost,c) {
		maxus();
		env.like.addlike({
			id_post : env.messages_list.get(idPost).id
		}, function(d) {
			if (!("response" in d)) {
				minus();
				
			}
			c();
		})
	}
	env.auth.kk=true;
	$("#likes").click(function() {
		idPost = $("#postModalLecture").attr("data-index");

		
		if(env.auth.kk==true){
			env.post.reloadPost(idPost, function(f) {
				console.log(f);
			})
		env.auth.kk=false;
		selected = $(this).attr("selectedf");

		

		if (selected != null && selected == "true") {

			isSelected(idPost,function(){
				setTimeout(function(){
					env.auth.kk=true;
				},3000);
			});
			

		} else {

			isNotSelected(idPost,function(){
				setTimeout(function(){
					env.auth.kk=true;
					},3000);
				});
			

		}
		env.messages_list.get(idPost).nb_like=$("#likep").html();
		
		$(".grid-item[data-index="+idPost+"]").find(".nb_likes_grid_item").html($("#likep").html());
		}
	});
	
	$("#commentaire2").click(function(){
		$("#modalspanComment").replace_motif("baseImg",env.var.bases.baseImg);
		idp=$('#postModalLecture').attr("data-index");
		mess=env.messages_list.get(idp);
		mess.getComments(env,idp,function(d){
			console.log(d);
			item=d.HTML();
			edf=$("#postModalComments #commentslists").append(item);
			
			console.log(item);
			var myId=env.my.id;
			for (ls in d.mess) {
				if (d.mess[ls].id_user==myId) {
					console.log(d.mess[ls].id);
					$(".grid-item[data-index='"+(d.mess[ls].id)+"'] .croixSuppression.mc").removeClassAlways("hidden");
					$(".grid-item[data-index='"+(d.mess[ls].id)+"'] .modification.mc").removeClassAlways("hidden");
				}
			}
		});
		//$(".modale").addClassAlways("hidden");
		$("#postModalComments").toggleClass("hidden");
		//$("#modalspanComm").replace_motif("baseImg",env.var.bases.baseImg);
		
	});
	
	$("#newComm").click(function(){
		if ($('#newCommentaire').val().length > 0) {
			$.getJSON("addcomment", {
				key : $.cookie("key"),
				text : $('#newCommentaire').val(),
				id_post : env.messages_list.get($("#postModalLecture").attr("data-index")).id
			}, function(d) {
				console.log(d);
				if ("response" in d) {
					sd = $("#comsp").val();
					df = parseInt(sd, 10);
					$("#comsp").val(df + 1);
					$('#newCommentaire').val("");
					env.messages_list.get($("#postModalLecture").attr("data-index")).getComments(env,$("#postModalLecture").attr("data-index"),function(d){
						$("#comsp").val(d.mess.count);
						item=d.HTML();
						edf=$("#listCommentaire #commentslists").html(item);
						console.log(item);
						console.log(d);
					});
			}
		})
	
		}
	});

	$("#commentaire").click(
			function() {
				if ($('#newCommentaire').val().length > 0) {
					env.comment.addcomment({
						text : $('#newCommentaire').val(),
						id_post : env.messages_list.get($("#postModalLecture")
								.attr("data-index")).id
					}, function(d) {
						console.log(d);
						if ("response" in d) {
							sd = $("#comsp").val();
							df = parseInt(sd, 10);
							$("#comsp").val(df + 1);
							$('#newCommentaire').val("");
							env.messages_list.get($("#postModalLecture").attr("data-index")).getComments(env,$("#postModalLecture").attr("data-index"),function(d){
								$("#comsp").html(d.mess.count);
								item=d.HTML();
								edf=$("#postModalComments #commentslists").html(item);
								console.log(item);
								console.log(d);
								$("#postModalComments #commentslists")[0].scrollTop = 0;
							});
						}
					})
				}
			});
	$('#clipboard').on('click', function() {
		env.func_tools.copyTextToClipboard(editor2.getSelectedText());
    });
});