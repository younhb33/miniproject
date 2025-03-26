// 상담신청 버튼 클릭 시 실행되는 함수
function meetok() {

    if (countCheck("rent_type") < 1) {
        alert("임대형태를 최소 1개 체크해주셔야 합니다.");
    } else if (countCheck("house_type") < 1) {
        alert("주거형태를 최소 1개 체크해주셔야 합니다.");
    } else if (frm.meeting_date.value == "") {
        alert("날짜를 선택해주세요.");
    } else {
        var sel = new Date(frm.meeting_date.value);
        var now = new Date();
        now.setHours(0, 0, 0, 0);

        if (sel.getTime() <= now.getTime()) {
            alert("상담일시는 오늘 이후 날짜만 가능합니다.");
        } else if (frm.mcontent.value == "") {
            alert("상담내용을 입력해주세요.");
        } else if (frm.mcontent.value.length < 10) {
            alert("상담내용은 10자 이상 입력해주세요.");
        } else {
            frm.submit();
        }
    }
}

function countCheck(name) {
    var list = document.getElementsByName(name);
    var i = 0;
    var count = 0;

    while (i < list.length) {
        if (list[i].checked) {
            count++;
        }
        i++;
    }
    return count;
}