<div id="postModalLecture" class="hidden" style="position:fixed;width:100vw;height:100vh;top:0px;left:0px;background-color: #161616;z-index: 27777;" data-index="-1">
	<span onclick="$('#postModalLecture').toggleClass('hidden');" style="cursor:pointer">
		<img style="position: absolute; top: 0; right: 0; margin-top: 10px;" width="30px" src="http://li328.lip6.fr:8280/TwisterV2/img/fermer.png" />
	</span>
	<h4 style="text-align: center; background-color: #FFFFFF; color: #000000; padding-top: 5px; height: 30px;" id="modal_user"></h4>
	<h4 style="text-align: center; background-color: #FFFFFF; color: #000000; padding-top: 5px; height: 30px;" id="modal_title"></h4>
	<h5 style="text-align: center; background-color: #FFFFFF; color: #000000; padding-top: 5px; height: 30px;" id="modal_desc"></h5>
	<div id="editor2" style="width:100%;height:74vh; margin-top: 5px;">
	</div>
	<div class="form-group">
		<input type="text" id="newCommentaire" placeholder="Commentaire..." style="margin-top: 7px;width: 40vw; vertical-align: middle;margin-right: 60px;right: 0;position: absolute;">
		<button style="margin-left: 30px;background-color:black;color:white;" class="btn btn-primary pull-right" type="button" id="commentaire"><span class="comsp">{{nb_coms}}</span><i class="glyphicon glyphicon-comment"></i></button>
		<button style="margin-right: 30px;background-color:black;color:white; " class="btn btn-primary" type="button" id="cl" onclick="editor2.selectAll()">Select All</button>
		<button style="margin-right: 30px;background-color:black;color:white; " class="btn btn-primary pull-left" type="button" id="likes"><span id="likep">{{nb_likes}}</span><i class="glyphicon glyphicon-heart"></i></button>
	</div>   
</div>


 <style>
	.hh{
		height:90vh !important;
	}
	#editor{
		z-index: 999;
		height: 150px;
	}
	#form_post{
		z-index: 999;
	}
	.langageSelect {
		margin-left: 30px;
		background-color: #3B5999;
		color: #ffffff;
		height: 35px;
	}
	.inputTitle {
		border: 0;
		color: #000000;
		left: 50%;
		width: 100%;
		text-align: center;
		height: 30px;
		vertical-align: middle;
		background-color: white;
	}
</style>