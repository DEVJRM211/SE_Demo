<html>
    <head>
        <title>Demo-Homepage</title>
       </head>
       <style>
            html
            {
                background-color    :   #304FFE;
            }
            form
            {
                width               :   400px;
                padding-Top         :   30px;
                padding-Bottom      :   50px;
                margin-Top          :   200px;
                background-color    :   #FFFFFF;
                border-radius       :   8px 8px 8px 8px;
                color               :   #212121;
            }
            form .lgbtn
            {
                width               :   300px;
                height              :   45px;
                margin-Top          :   40px;
                background-color    :   #304FFE;
                border              :   0px 0px;
                border-radius       :   8px 8px;
                color               :   #ffffff;
                font-size           :   20px;

            }
            form .uname
            {
                width               :   300px;
                height              :   45px;

            }
            form .upass
            {
                width               :   300px;
                height              :   45px;

            }
            form .sgin_red
            {
                display			    :   block;
                color			    :   #212121;
                text-align		    :   center;
                text-decoration		:   none;
                margin-Top          :   30px;
                font-size           :   15px;
            }
       </style>
   <body>
<center>
      <form  action = "/ResponseData" method = "POST">

        <h4>Sign in to your account</h4>
        <br>

         <input  placeholder="User Name" class="uname" type = "text" name = "uname">
         <br />
         <br>
         <input placeholder="Password" class="upass" type = "password" name = "upass" /><br>
         <input  class="lgbtn"  type = "submit"  name="datasb" value = "Sign In" />
         <br>
         <a class="sgin_red" href="signup_page.jsp"  name="Sgin_lbl">Dont have an account? <span style="color:#304FFE;">Sign Up</span></a>

      </form>
     </center>
   </body>
</html>