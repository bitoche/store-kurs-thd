<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Покупатели</title>
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
<h1>Покупатели</h1>
<a href="/">На главную</a>
<a href="/buyer">Перезагрузить</a>
<div class="tableContainer">
    <table>
        <thead>
        <th>id</th>
        <th>name</th>
        <th>telephone_number</th>
        </thead>
        <#if listBuyer ?has_content>
            <tbody>
            <#list listBuyer?sort_by('id') as ra>
                <tr>
                    <td>${ra.id?string('0')}</td>
                    <td>${ra.name}</td>
                    <td>${ra.telephone_number}</td>
                </tr>
            </#list>
            </tbody>
        </#if>
    </table>
</div>
</body>
