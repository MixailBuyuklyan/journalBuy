<#ftl encoding='Windows-1251'>
<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">����������� �����:</label>
            <div class="col-sm-4">
                <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                       class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="������� ����� ����������� �����"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">������:</label>
            <div class="col-sm-4">
                <input type="password" name="password"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="������� ������"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">�������������:</label>
                <div class="col-sm-4">
                    <input type="password" name="password2"
                           class="form-control ${(password2Error??)?string('is-invalid', '')}"
                           placeholder="����������� ������"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">�������:</label>
                <div class="col-sm-4">
                    <input type="text" name="lastname" value="<#if lastname??>${lastname}</#if>"
                           class="form-control ${(lastnameError??)?string('is-invalid', '')}"
                           placeholder="������� �������"/>
                    <#if lastnameError??>
                        <div class="invalid-feedback">
                            ${lastnameError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">���:</label>
                <div class="col-sm-4">
                    <input type="text" name="firstname" value="<#if firstname??>${firstname}</#if>"
                           class="form-control ${(firstnameError??)?string('is-invalid', '')}"
                           placeholder="������� ���"/>
                    <#if firstnameError??>
                        <div class="invalid-feedback">
                            ${firstnameError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">��������:</label>
                <div class="col-sm-4">
                    <input type="text" name="secondname" value="<#if secondname??>${secondname}</#if>"
                           class="form-control ${(secondnameError??)?string('is-invalid', '')}"
                           placeholder="������� ��������"/>
                    <#if secondnameError??>
                        <div class="invalid-feedback">
                            ${secondnameError}
                        </div>
                    </#if>
                </div>
            </div>
        </#if>
        <div class="form-group row">
            <div class="col-sm-2">
                <#if !isRegisterForm><a href="/registration">�������� ������������</a></#if>
            </div>
            <div class="ml-3">
                <button class="btn btn-primary" type="submit">
                    <#if isRegisterForm>�������<#else>�����</#if>
                </button>
            </div>
        </div>
    </form>
</#macro>

<#macro logout>
    <div>
        <form action="/logout" method="post">
            <button class="btn btn-primary" type="submit">�����</button>
        </form>
    </div>
</#macro>