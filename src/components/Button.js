const Button = ({label,color,onClick}) => {
    
    return (
        <button onClick={onClick} color = {color} className= "btn">{label}</button>
        
    )
}
Button.defaultProps = {
    label: "Beep",
    color: "steelblue"
}
export default Button