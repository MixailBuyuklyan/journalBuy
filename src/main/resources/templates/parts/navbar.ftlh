<#ftl encoding='Windows-1251'>

<#import "login.ftlh" as lo>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">������ ���������� ������</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">���������</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/main">����</a>
            </li>
        </ul>
        <@lo.logout/>
    </div>
</nav>