<#ftl encoding='Windows-1251'>
<#import "parts/common.ftlh" as c>

<@c.page>
    ������ �������������
    <table>
        <thead>
        <tr>
            <th>��� ������������</th>
            <th>����</th>
            <th>��������</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/admin/${user.getUsr_id()}">�������������</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>