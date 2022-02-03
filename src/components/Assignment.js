import { useState} from 'react'
import Button from './Button'
const Assignment = ({assignment}) => {
    const onClick = (e) => {
        console.log("Click")
    }
    return (
        <div className="task">
            <h3>
                {assignment.name}
                <br/>
                {assignment.coursecode}
                <br/>
                {assignment.duedate}
            </h3>
            
        </div>
    )
}
export default Assignment