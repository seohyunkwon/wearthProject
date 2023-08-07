$(document).ready(function() {
    /* 체크박스 전체 선택 기능 */
    $('#selectAllCheckbox').change(function() {
        $('tbody input[type="checkbox"]').prop('checked', $(this).prop('checked'));
    });

    /* 회원정보 삭제기능 */
    $(".btn-primary-delete").on('click', function() {
        const isConfirmed = confirm("정말로 삭제하겠습니까?");
        if (isConfirmed) {
            const userId = $(this).data('user-id');
            console.log("userID야?" ,userId);
            deleteUser(userId);        }
    });
});

function deleteUser(userId) {
    $.ajax({
        url: `/deleteUser/${userId}`, // 서버 엔드포인트 (실제 경로를 확인하여 수정하세요)
        type: 'DELETE',
        success: function(response) {
            if (response.success) {
                location.reload(); // 테이블 새로 고침
            } else {
                alert('회원 삭제에 실패했습니다.');
            }
        },
        error: function(error) {
            alert('서버 오류로 회원 삭제에 실패했습니다.');
        }
    });
}