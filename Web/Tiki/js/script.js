window.onscroll = function() { appearScroll() };

function scrollToTop() {
    $("html, body").animate({ scrollTop: "0" });
};

function appearScroll() {
    if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
        document.getElementById("upArrow").className = "appear";
    } else if (document.body.scrollTop <= 200 || document.documentElement.scrollTop <= 200) {
        document.getElementById("upArrow").className = "hidden";
    }
}