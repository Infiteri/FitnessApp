import { useEffect, useState } from "react";
import Button from "./Button";
import Input from "./Input";
import ApiUtils from "../utils/ApiUtils"
import Exercises from "./Exercises";

export default function WorkoutDetail({ workout, userId, onWorkoutUpdate, onWorkoutDelete }) {
    if (!workout) return <div></div>;

    const [isEdit, setEdit] = useState(false);
    const [name, setName] = useState(workout.name);
    const [dateTime, setDateTime] = useState(workout.workoutDateTime);

    useEffect(() => {
        if (workout) {
            setName(workout.name);
            setDateTime(workout.workoutDateTime);
            setEdit(false); // reset edit mode when switching workouts
        }
    }, [workout]);

    const handleSaveOrEditClick = async () => {
        if (isEdit) {
            const result = await ApiUtils.Fetch("/api/v1/workout", {
                method: "PUT",
                body: JSON.stringify({
                    id: workout.id,
                    name: name,
                    workoutDateTime: dateTime,
                    user: {
                        id: userId
                    }
                })
            })

            if (result.ok && onWorkoutUpdate) {
                const res = await result.json();
                onWorkoutUpdate(res);
            }
        }

        setEdit(!isEdit);
    };

    const handleDeleteClick = async () => {
        const result = await ApiUtils.Fetch("/api/v1/workout?id=" + workout.id, {
            method: "DELETE",
        })

        if (result.ok && onWorkoutDelete) onWorkoutDelete(workout);
    }

    function ThisButton({ text, color }) {
        return <Button text={text} style={color + " px-8 py-1"} onClick={handleSaveOrEditClick} />;
    }

    return (
        <div className="w-full h-full p-5 bg-neutral-500">
            {isEdit ? (
                <Input
                    style="text-5xl font-bold w-full mb-3 p-1 text-white"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
            ) : (
                <p className="text-5xl text-white font-bold">{name}</p>
            )}

            {isEdit ? (
                <Input
                    type="datetime-local"
                    style="mt-5 text-neutral-900 w-full p-1  text-white"
                    value={dateTime}
                    onChange={(e) => setDateTime(e.target.value)}
                />
            ) : (
                <p className="mt-5 text-neutral-900">{dateTime}</p>
            )}

            <p className="text-m italic text-neutral-600 mt-4">Exercises done during this workout</p>

            <div className="mt-5">
                <Exercises workout={workout} />
            </div>

            <div className="mt-6 flex">
                <ThisButton text={isEdit ? "Save" : "Edit"} color={isEdit ? "bg-yellow-500" : "bg-green-600"} />
                <Button text="Delete" style="bg-red-600 px-8 py-1 ml-5" onClick={handleDeleteClick} />
            </div>

        </div>
    );
}
