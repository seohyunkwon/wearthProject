$(document).ready(function() {
    
    //토큰선언
    var header = $("meta[name='_csrf_header']").attr('content');
    var token = $("meta[name='_csrf']").attr('content');
    
    /* 체크박스 전체 선택 기능 */
    $('#selectAllCheckbox').change(function() {
        $('tbody input[type="checkbox"]').prop('checked', $(this).prop('checked'));
        updateDeleteButton(); // 삭제 버튼 상태 업데이트
    });

    $('input[name="userCheckbox"]').on('change', function() {
        if ($(this).prop('checked')) {
            const checkUserId = $(this).data('user-id');
            console.log("Checked user ID:", checkUserId);
        }
        updateDeleteButton(); // 삭제 버튼 상태 업데이트
    });

    //************************************아이디 생성 ***************************//
    // 아이디 중복확인 checkId
    $('#checkIdButton').click(function() {
        var userId = $('#inputId').val();
        if (userId.trim() === '') {
            alert('아이디를 입력해주세요.');
            return;
        }

        $.ajax({
            url: '/checkId',
            type: 'POST',
            data: { id: userId },
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token); // CSRF 토큰을 헤더에 추가
            },
            success: function(response) {
                if (response === "success") {
                    alert('중복된 아이디입니다');
                } else {
                    alert('사용가능한 아이디입니다');
                }
            },
            error: function(error) {
                alert('서버 오류로 중복확인에 실패했습니다.');
            }
        });
    });

    //아이디 생성 saveButton
    $('#saveButton').click(function() {
        // 확인 메시지 띄우기

        const isConfirmed = confirm("저장하시곘습니까?");
        if (isConfirmed) {
            var formData = {
                id: $('#inputId').val(),
                pwd: $('#inputPwd').val(),
                u_name: $('#inputName').val(),
                date_birth: $('#inputDateOfBirth').val(),
                gender: $('#inputGender').val(),
                email: $('#inputEmail').val(),
                nickname: $('#inputNickname').val(),
                residence: $('#inputResidence').val(),
                phone: $('#inputPhoneNumber').val(),
                point: $('#inputPoint').val()
            };

            console.log(formData);

                $.ajax({
                    url: '/insertUser',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(formData),
                    beforeSend: function(xhr) {
                        xhr.setRequestHeader(header, token);
                    },
                    success: function(response) {
                        if (response === "success") {
                            alert('저장되었습니다');

                            window.location.href = '/adminUserList/1';

                        } else {
                            alert('저장에 실패했습니다');
                        }
                    },
                error: function(error) {
                    console.error(error); // 오류 정보 출력
                    alert('서버 오류로 저장에 실패했습니다.');
                }
            });
        }
    });


        /* 회원정보 삭제기능 */
    $(".btn-primary-delete").on('click', function() {
        console.log('회원정보 삭제기능 동작');
        const isConfirmed = confirm("정말로 삭제하겠습니까?");
        if (isConfirmed) {
            const userId = $(this).data('user-id');
            console.log("userID야?", userId);
            deleteUser(userId);
        }
    });

    //선택 삭제 버튼
    // 선택된 회원 삭제
    $(".btn-primary-delete-user").on('click', function() {
        const checkedUserIds = []; // 체크된 user ID를 담을 배열
        $('input[name="userCheckbox"]:checked').each(function () {
            const checkedUserId = $(this).data('user-id');
            checkedUserIds.push(checkedUserId);
        });
        console.log("체크된 UserNO 확인 ", checkedUserIds);

        const isConfirmed = confirm("정말로 삭제하겠습니까?");
        if (isConfirmed) {
            deleteSelectedUser(checkedUserIds);
        }
    });


    // 삭제 버튼 상태 업데이트
    function updateDeleteButton() {
        const checkedUserIds = getCheckedUserIds();
        const deleteButton = $(".btn-primary-delete-user");

        if (checkedUserIds.length > 0) {
            deleteButton.prop('disabled', false); // 선택된 회원이 있을 때 활성화
        } else {
            deleteButton.prop('disabled', true); // 선택된 회원이 없을 때 비활성화
        }
    }
});

function deleteSelectedUser(checkedUserIds){
    var header = $("meta[name='_csrf_header']").attr('content');
    var token = $("meta[name='_csrf']").attr('content');

    $.ajax({
        url: `/deleteSelectedUser`,
        type: 'DELETE',
        data: JSON.stringify(checkedUserIds),
        contentType: 'application/json',
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token); // CSRF 토큰을 헤더에 추가
        },
        success: function(response) {
            if (response == 'success') {
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



function deleteUser(userId) {

    var header = $("meta[name='_csrf_header']").attr('content');
    var token = $("meta[name='_csrf']").attr('content');

    $.ajax({
        url: `/deleteUser/${userId}`,
        type: 'DELETE',
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token); // CSRF 토큰을 헤더에 추가
        },
        success: function(response) {
            if (response == 'success') {
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

// 선택된 User Id 가져오기
function getCheckedUserIds() {
    return $('input[name="userCheckbox"]:checked').map(function() {
        return $(this).data('user-id');
    }).get();
}