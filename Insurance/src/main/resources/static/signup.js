$(document).ready(function(){
  $('.yyy').click(function(){
    if ($('.username').val()==''){
      $('.err').removeClass('err2');
    }
    else{
      $('.err').addClass('err2');
      if ($('.pass').val()==''){
        $('.pass_err').removeClass('pass_err2');
      }
      else{
        $('.pass_err').addClass('pass_err2');
        alert($('.username').val()+' you are logged in!');
      }
    }
  });

  $('.www').click(function(){
    if ($('.forgot_username').val()==''){
      $('.error').removeClass('error2');
    }
    else{
      $('.error').addClass('error2');
      if ($('.forgot_email').val()==''){
        $('.error3').removeClass('error4');
      }
      else{
        $('.error3').addClass('error4');
        if ($('.forgot_pass').val()==''){
          $('.pass_error').removeClass('pass_error2');
        }
        else{
          $('.pass_error').addClass('pass_error2');
          alert($('.forgot_username').val()+' your password has been created!');
        }
      }
    }
  });

  $('.zzz').click(function(){
    if ($('.user_nnn').val()==''){
      $('.u_name').removeClass('u_name2');
    }
    else{
      $('.u_name').addClass('u_name2');
      if ($('.user_phone').val()==''){
        $('.p_num').removeClass('p_num2');
      }
      else{
        $('.p_num').addClass('p_num2');
        var phone_length=$('.user_phone').val();
        if (phone_length.length<=9 || phone_length.length>=11){
          $('.p_num3').removeClass('p_num4');
        }
        else{
          $('.p_num3').addClass('p_num4');
          if ($('.user_mail').val()==''){
            $('.u_mail').removeClass('u_mail2');
          }
          else{
            $('.u_mail').addClass('u_mail2');
            if ($('.user_pass').val()==''){
              $('.u_pass').removeClass('u_pass2');
            }
            else{
              $('.u_pass').addClass('u_pass2');
              var pass_length=$('.user_pass').val();
              if (pass_length.length<=7 || pass_length.length>=15){
                $('.u_pass3').removeClass('u_pass4');
              }
              else{
                $('.u_pass3').addClass('u_pass4');
                alert($('.user_nnn').val()+' your account has been created!');
              }
            }
          }
        }
      }
    }
  });
});