<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Заказы</title>
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
<h1>Заказы</h1>
<a href="/">На главную</a>
<a href="/order">Перезагрузить</a>
<div class="tableContainer">
    <table>
        <thead>
        <th>id</th>
        <th><a href="/store">id_store</a></th>
        <th><a href="/buyer">id_buyer</a></th>
        <th>responsible</th>
        <th>date</th>
        <th><a href="/product">id_product</a></th>
        </thead>
        <#if listOrder ?has_content>
            <tbody>
            <#list listOrder?sort_by('id') as ra>
                <tr>
                    <td>${ra.id?string('0')}</td>
                    <td>${ra.id_store?string('0')}</td>
                    <td>${ra.id_buyer?string('0')}</td>
                    <td>${ra.responsible}</td>
                    <td>${ra.getStringDate()}</td>
                    <td>${ra.id_product?string('0')}</td>
                </tr>
            </#list>
            </tbody>
        </#if>
    </table>
</div>
</body>
