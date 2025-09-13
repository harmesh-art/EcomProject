<%-- File: register.jsp --%>
<%@include file="header.jsp" %>

<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card">
            <div class="card-header">
                <h4>Create an Account</h4>
            </div>
            <div class="card-body">
                <%-- In File: register.jsp --%>

<form action="register" method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Full Name</label>
        <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email address</label>
        <input type="email" class="form-control" id="email" name="email" required>
    </div>
    
    <div class="mb-3">
        <label for="phone" class="form-label">Mobile Number</label>
        <input type="tel" class="form-control" id="phone" name="phone" required>
    </div>

    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
</form>

            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>