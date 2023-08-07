$(document).ready(function() {
    // 사용자가 클릭한 메뉴를 기록하는 변수
    var activeMenu = null;

    $('[data-bs-toggle="collapse"]').each(function() {
        var $el = $(this);
        var targetSelector = $el.attr('href');

        $el.on('click', function(e) {
            e.preventDefault();

            // 사용자가 다른 메뉴를 클릭한 경우, 이전에 열렸던 서브 메뉴를 닫습니다.
            if (activeMenu && activeMenu !== targetSelector) {
                $(activeMenu).collapse('hide');
            }

            // 클릭한 메뉴의 서브 메뉴를 토글합니다.
            $(targetSelector).collapse('toggle');

            // 클릭한 메뉴를 activeMenu 변수에 기록합니다.
            activeMenu = activeMenu === targetSelector ? null : targetSelector;
        });
    });
});