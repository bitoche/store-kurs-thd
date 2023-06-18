<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Магазины</title>
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
<h1>Магазины</h1>
<a href="/">На главную</a>
<a href="/store">Перезагрузить</a>
<div class="tableContainer">
    <table>
        <thead>
        <th>id</th>
        <th>address</th>
        <th>contact_details</th>
        </thead>
        <#if listStore ?has_content>
            <tbody>
            <#list listStore?sort_by('id') as ra>
                <tr>
                    <td>${ra.id?string('0')}</td>
                    <td>${ra.address}</td>
                    <td>${ra.contact_details}</td>
                </tr>
            </#list>
            </tbody>
        </#if>
    </table>
</div>
</body>
