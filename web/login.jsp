<%-- File: login.jsp --%>
<%@include file="header.jsp" %>

<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card">
            <div class="card-header">
                <h4>Login</h4>
            </div>
            <div class="card-body">
                <form action="login" method="post">
                    <div class="mb-3">
                        <label for="login-email" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="login-email" name="login-email" required>
                    </div>
                    <div class="mb-3">
                        <label for="login-password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="login-password" name="login-password" required>
                    </div>
                    <center> <button type="submit" class="btn btn-primary">Login</button></center>
                </form>
                <%-- In File: login.jsp --%>

                
                <div class="card-footer text-center">
                    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
                </div>
            </div>
        </div>
    </div>

            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>