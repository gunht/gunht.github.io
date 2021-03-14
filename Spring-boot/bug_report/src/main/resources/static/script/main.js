$(function () {
    configToastr();
});

function signedValidate(status = false, fullName = '') {
    if (status === true) {
        isLogin = true;
        let signedLink = `
  <a id="account-setting" class="nav-link account-setting font-weight-bold" href="/logout">Logout as ${fullName}</a>`;

        $('.account-setting').replaceWith(signedLink);
        $('#create-post').show();
        $('#form-comment').show();
    } else {
        isLogin = false;
        let notSignedLink = `
  <div class="navbar-nav account-setting" data-target="#signInSignUp">
                    <div class="nav-item">
                        <a href="/login" class="nav-link font-weight-bold mr-2">Login</a>
                    </div>
                    <div class="nav-item">
                        <a href="/signup" class="nav-link btn btn-primary font-weight-bold">Sign up</a>
                    </div>
                </div>
  `;
        $('.account-setting').replaceWith(notSignedLink);
        $('#create-post').hide();
        $('#form-comment').hide();
    }
}


function configToastr() {
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": "toast-top-center",
        "preventDuplicates": true,
        "onclick": null,
        "showDuration": "2000",
        "hideDuration": "1000",
        "timeOut": "1000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
}