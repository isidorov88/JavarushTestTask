<#import "parts/common.ftl" as c>
<#import "parts/form.ftl" as f>

<@c.page>

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
                <td align="left"><span>${name}</span></td>
                <td align="center"><span>${necessary?then("Да", "Нет")}</span></td>
                <td align="center"><span>${amount}</span></td>

            </tr>


            </tbody>
        </table>

    <@f.form/>
</@c.page>