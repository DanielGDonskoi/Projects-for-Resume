import Button from "./Button"
const Header = ({title,subheading,onAdd,showAdd}) => {
    return (
        <header className = "header">
            <h1>{title}</h1>
            <h2>{subheading}</h2>
        </header>
        
    )

}
Header.defaultProps = {
    title: "Homework Helper",
    subheading: "Due in this week"
}
export default Header