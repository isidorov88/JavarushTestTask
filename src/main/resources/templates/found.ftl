<#import "parts/common.ftl" as c>

<@c.page>
    <#if part??>
        <table border="1" cellpadding="5"
               style="border-collapse: collapse; border: 1px solid black;">
            <thead>
            <tr>
                <th align="left">Название</th>
                <th>Необходимость</th>
                <th>Количество</th>

            </tr>
            </thead>

            <tbody>

                <tr>
                    <td align="left"><span>${part.name}</span></td>
                    <td align="center"><span>${part.necessary?then("Да", "Нет")}</span></td>
                    <td align="center"><span>${part.amount}</span></td>
                    <td><a class="btn btn-danger"  href="/delete/${part.id}"onclick="return confirm('Удалить строку?')">Delete</a></td>
                    <td><a class="btn btn-primary"  href="/update?id=${part.id}">Update</a></td>
                </tr>


            </tbody>
        </table>
        <#else>
            <div class="alert alert-danger" role="alert"><h4 class="alert-heading">Деталь не найдена</h4><div>
        <hr>
    </#if>

    <div class="alert-heading"><a class="btn btn-primary m-1" href="/partsList">Список запчастей</a>
    <a class="btn btn-primary m-1" href="/add">Добавить запчасть</a></div>


</@c.page>