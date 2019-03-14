<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="btn btn-link text-dark" href="<%= request.getContextPath()%>/Spa/Admin/index.jsp" style="background-color: transparent; text-decoration: none">
                    <span data-feather="home"></span>
                    Dashboard
                </a>
            </li>
            <li class="nav-item">
                <div class="btn-group dropright">
                    <button type="button" class="btn btn-link dropdown-toggle text-dark" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color: transparent; text-decoration: none">
                        Clients
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="<%= request.getContextPath()%>/Spa/Admin/Clientele.jsp">View Clientele</a>
                        <a class="dropdown-item" href="<%= request.getContextPath()%>/Spa/Admin/AddClient.jsp">Add Client</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="btn btn-link text-dark" href="<%= request.getContextPath()%>/Admin/index.jsp" style="background-color: transparent; text-decoration: none">
                    <span data-feather="home"></span>
                    Statistics
                </a>
            </li>
            <li class="nav-item">
                <a class="btn btn-link text-dark" href="<%= request.getContextPath()%>/Admin/index.jsp" style="background-color: transparent; text-decoration: none">
                    <span data-feather="home"></span>
                    Reports
                </a>
            </li>

        </ul>
    </div>
</nav>
