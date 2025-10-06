export default function Workout({ workout, onClick }) {

    return <div onClick={onClick}>
        <h1 className="bg-neutral-500 p-5">

            <p className="text-3xl text-white font-bold">
                {workout.name}
            </p>

            <p className="mt-5 text-neutral-900">
            { workout.workoutDateTime }
            </p>
        </h1>
    </div>
}