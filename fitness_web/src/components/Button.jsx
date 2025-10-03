export default function Button({text, style="", onClick}) {
    return <button className={style + " text-white"} onClick={onClick}>{text}</button>
}