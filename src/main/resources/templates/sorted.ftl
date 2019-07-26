<#import "parts/common.ftl" as c>

<@c.page>

    <form method="get" action="/found">
        <input type="text" class="form-control-sm" name="name" value="${name?if_exists}" placeholder="Название детали">
        <button class="btn btn-success m-1" type="submit">Найти</button>
    </form>
    <table border="1" cellpadding="5"
           style="border-collapse: collapse; border: 1px solid black;">
        <thead>
        <tr>
            <th align="left">Название</th>
            <th><a style="color: black" href="/sortedReverse" >Необходимость</a></th>
            <th>Количество</th>

        </tr>
        </thead>

        <tbody>
        <#list parts?sort_by("necessary")?reverse as part>
            <tr>
                <td align="left"><span>${part.name}</span></td>
                <td align="center"><span>${part.necessary?then("Да", "Нет")}</span></td>
                <td align="center"><span>${part.amount}</span></td>
                <td><a class="btn btn-danger"  href="/delete/${part.id}"onclick="return confirm('Удалить строку?')">Удалить</a></td>
                <td><a class="btn btn-primary"  href="/update?id=${part.id}">Изменить</a></td>
            </tr>

        <#else >
            Список пуст
        </#list>
        </tbody>
        </tfoot>
        <td align="left"><b>Можно собрать</b></td>
        <td align="center">${necessaryAmount}</td>
        <td align="center"><b>Компьютеров</b></td>
        </tfoot>
    </table>
    <div><a class="btn btn-success m-1" href="/add">Добавить запчасть</a></div>
</@c.page>