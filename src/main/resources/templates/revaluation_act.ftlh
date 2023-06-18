<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>revaluation_act</title>
    <link rel="stylesheet" href="css/table.css">
    <style>
        .filterContainer {
            padding: 10px;
            border: solid #eee 1px;
            margin: 3px 3px 10px;
        }
    </style>
</head>
<body>
<h1>revaluation_act</h1>
<a href="/">На главную</a>
<a href="/revaluation_act">Перезагрузить</a>
<div class="tableContainer">
    <table>
        <thead>
        <th>id</th>
        <th><a href="/product">id_product</a></th>
        <th>summ</th>
        <th>responsible</th>
        <th>date</th>
        <th>Управление</th>
        </thead>
        <#if listRev_act ?has_content>
            <tbody>
            <#list listRev_act?sort_by('id') as ra>
                <tr>
                    <td>${ra.id?string('0')}</td>
                    <td>${ra.id_product?string('0')}</td>
                    <td>${ra.summ?string('0')}</td>
                    <td>${ra.responsible}</td>
                    <td>${ra.getStringDate()}</td>
                    <td>
                        <a href="/revact/delete/${ra.id}"
                           style="color: black; background: #efefef; padding: 1px; text-align: center; text-decoration: none; outline: none; border: solid #1a1a1a 1px; border-radius: 10%">Удалить</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </#if>
    </table>
</div>
</body>
