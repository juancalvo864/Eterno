import React,{useEffect, useState} from 'react'
import { listEmployees } from '../service/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {
    
    const [employees,setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        listEmployees().then((response) =>{
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    },[])

    function addNewEmployee(){
        navigator('/add-employee')
    }

  return (
    <div className='container'>
        <h2 className='text-center'>List of Employees</h2>
        <button className='btn btn-primary'onClick={addNewEmployee}>Add of Employees</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employe Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email Id</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(empployee => 
                        <tr key={empployee.id}>
                            <td>{empployee.id}</td>
                            <td>{empployee.firstName}</td>
                            <td>{empployee.lastName}</td>
                            <td>{empployee.email}</td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent