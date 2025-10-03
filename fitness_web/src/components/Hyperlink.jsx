export default function Hyperlink({ text, href, style = "", onClick }) {
    return <a href={href} className={style + " text-blue-400 cursor-pointer "} onClick={onClick}>{text}</a>
}