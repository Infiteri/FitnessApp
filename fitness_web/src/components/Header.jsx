export default function Header({ text, style }) {
    const styles = style + " font-bold text-white";

    return (
        <h1 className={styles}>
            {text}
        </h1>
    )
}
