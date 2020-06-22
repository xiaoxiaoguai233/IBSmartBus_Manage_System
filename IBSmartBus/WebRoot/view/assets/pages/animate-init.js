/*
 Template Name: Annex - Bootstrap 4 Admin Dashboard
 Author: Mannatthemes
 Website: www.Mannatthemes. 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>com
 File: Animation demo js
 */

function testAnim(x) {
    $('#animationSandbox').removeClass().addClass(x + ' animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function() {
        $(this).removeClass();
    });
};

$(document).ready(function() {
    $('.js--triggerAnimation').click(function(e) {
        e.preventDefault();
        var anim = $('.js--animations').val();
        testAnim(anim);
    });

    $('.js--animations').change(function() {
        var anim = $(this).val();
        testAnim(anim);
    });
});
