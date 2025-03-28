function govisit() {
	if (frm.vdate.value == "") {
		alert("방문날짜를 선택해주세요.");
		return false;
	} else if (frm.vtime.value == "") {
		alert("방문일시를 선택해주세요.");
		return false;
	} else {
		var sel = new Date(frm.vdate.value);
		var now = new Date();
		now.setHours(0, 0, 0, 0);

		if (sel.getTime() <= now.getTime()) {
			alert("방문일시는 오늘 이후 날짜만 가능합니다.");
			return false;
		}
		var today = new Date();
		var seldate = new Date(frm.vdate.value);
		if (
			seldate.getFullYear() == today.getFullYear() &&
			seldate.getMonth() == today.getMonth() &&
			seldate.getDate() == today.getDate()
		) {
			var pt = frm.vtime.value.split(":");
			var vt = new Date();
			vt.setHours(parseInt(pt[0]), parseInt(pt[1]), 0, 0);
			if (vt.getTime() <= new Date().getTime()) {
				alert("현재 시간/날짜 이후의 방문시간을 선택해주세요.");
				return false;
			}
		}
		//방문인원체크
		var vr = document.getElementsByName("vcount");
		var w = 0;
		var count = 0;
		while (w < vr.length) {
			if (vr[w].checked == true) {
				count++;
			}
			w++;
		}
		if (count > 0) {
			frm.submit();
		} else {
			alert("방문인원을 선택해주세요.");
			return false;
		}
	}
}