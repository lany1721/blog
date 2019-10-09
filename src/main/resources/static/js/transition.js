$(function () {
  // page
  $('.layout').velocity('stop')
    .velocity('transition.slideUpIn', {
      delay: 500,
      duration: 1000,
      easing: 'easeInOutQuart',
      complete: function () {
        if ($('.sidebar-toc').length > 0) {
          setTimeout(function () {
            $('#toggle-sidebar').click()
          }, 200)
        }
      }
    });
  $('#top-container').velocity('stop')
    .velocity('transition.fadeIn', {
      delay: 500,
      duration: 1000,
      easing: 'easeInOutQuart'
    })
});
