import Workout from "./Workout";

export default function Workouts({ workouts, onClick }) {

    if(!workouts) return <div></div>

    return <div className="flex flex-col gap-5" >

        {workouts.map((w, k) => (<Workout key={k} workout={w} onClick={() => {onClick(w)}}/>))}

    </div>
}