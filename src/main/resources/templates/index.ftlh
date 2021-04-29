<!DOCTYPE html>  
<html lang="en">  
    <head>
        <meta charset="UTF-8">
        <title>Goldeneye</title>
    </head>
    <body>
        <h1>Goldeneye</h1>
        <h2>Email Creator</h2>
        <#if employee?? >
            <p>This is your data:</p>
            <p>Name: ${employee.name}</p>
            <p>Surname: ${employee.surname}</p>
            <p>Location: ${employee.location}</p>
            <p>Department: ${employee.department}</p>
            <p>and here is your company email:</p>
            <p>Email: ${employee.email}</p>
        <#else>
            <p>Please, fill the following form in order to receive a company email address.</p>
            <form action="/" method="post">
                <div>Name:</div>
                <input type="text" name="name">
                <div>Surname:</div>
                <input type="text" name="surname">
                <div>
                    <select name="location">
                        <option value="Milan">Milan</option>
                        <option value="Spain">Spain</option>
                        <option value="New York">New York</option>
                    </select>
                </div>
                <div>
                    <select name="department">
                        <option value="Design">Design</option>
                        <option value="Business">Business</option>
                        <option value="Advertising">Advertising</option>
                        <option value="Research & development">Research & development</option>
                    </select>
                </div>
                <div>
                <button>Send</button>
                </div>
            </form>
        </#if>

    </body>
</html>