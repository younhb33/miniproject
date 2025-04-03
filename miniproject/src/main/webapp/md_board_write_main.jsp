<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <form id="frm" method="post" action="./md_boardok" enctype="multipart/form-data">
    <section class="sub">
        <p>추천분양 정보 게시판</p>
        <div class="boards">이번주 신규 매물정보를 한눈에 확인하실 수 있습니다.</div>
        <div class="info_board">
          <ul>
            <li>제&nbsp;&nbsp;&nbsp;목</li>
            <li><input type="text" name="mtitle" class="board_in2"></li>
            <li>글쓴이</li>
            <li><input type="text" name="lname" class="board_in1" value="관리자" readonly></li>
            <li>썸네일 이미지</li>
            <li><input type="file" name="lfile"></li>
            <li class="litext">내&nbsp;&nbsp;&nbsp;용</li>
            <li class="litext">
                <textarea id="board_text" name="details">
                    
                </textarea>
            </li>
          </ul>
        </div>
        <div class="board_btn">
            <input type="button" value="등&nbsp;&nbsp;&nbsp;록" onclick="gopage()" class="btns">
        </div>
    </section>
        </form>
    <script>
   		window.onload = function(){
        CKEDITOR.replace('board_text',{
            height : 360
        });
    };
    </script>
    <script>
    function gopage() {
		if(frm.mtitle.value == ""){
			alert("제목을 입력하셔야 합니다.");
			return false;
		}else if(frm.lname.value != "관리자"){
			alert("글쓴이는 관리자만 등록할 수 있습니다.");
			return false;
		}else if(frm.lfile.value == ""){
			alert("썸네일 이미지를 첨부해 주셔야 합니다.");
			return false;
		}else {
			var txt = CKEDITOR.instances.board_text.getData();
			frm.details.value = txt;
			if(txt == ""){
				alert("내용을 입력하셔야 합니다.");
				return false;
			}else if(txt.length < 10){
				alert("최소 10자 이상 입력되어야 합니다.");
				return false;
			}else{
				frm.submit();
			}
		}

	}

    
    </script>