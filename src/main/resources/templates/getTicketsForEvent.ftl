<!DOCTYPE html>
<html>
    <head>
        <title>Tickets by event</title>
        <link rel="stylesheet" href="css/freemarker.css" />
    </head>
    <body>
        <h2>List of tickets</h2>

        <table>
            <tr>
                <th>Id</th>
                <th>Event</th>
                <th>Auditorium</th>
                <th>Date</th>
                <th>Seats</th>
                <th>User</th>
                <th>Price</th>
            </tr>

            <#list tickets as ticket>
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.event.name}</td>
                    <td>${ticket.event.auditorium.name}</td>
                    <td>${ticket.event.dateTime}</td>
                    <td>${ticket.seats}</td>
                    <td>${ticket.user.name}</td>
                    <td>${ticket.price}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>