import { useState} from 'react'
import Button from "./Button"
import Assignment from "./Assignment"
const Assignments = ({assignments}) => {
    
    const onClick = (e) => {
        console.log("Filtered")
    }
    const assignments2 = assignments.filter(assignment => assignment.coursecode != "3SH3")
    return (
        
        <>
        
        {assignments.map((assignment) => (<Assignment key={assignment.id} assignment = {assignment}/>))}
        </>
    )
}
export default Assignments