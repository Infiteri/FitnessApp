import { useState } from "react";
import { ChevronRight, ChevronDown } from "lucide-react";
import Button from "./Button";

import Body from "react-body-highlighter";

function ExerciseDetails({ exercise }) {
    if (!exercise) return null;

    const { name, muscles, intensity } = exercise;

    // Convert "CHEST TRICEPS" → ["chest", "triceps"]
    const muscleList = typeof muscles === "string"
        ? muscles.trim().split(/\s+/).map(m => m.toLowerCase())
        : [];

    // Convert to react-body-highlighter format
    const data = muscleList.map(m => ({ bodyPart: m, intensity: 1 }));

    return (
        <div className="flex flex-col items-center gap-4 mt-4 text-white">
            <h2 className="text-2xl font-bold">{name}</h2>
            <p className="text-gray-300">intensity: {intensity} / week</p>

            <Body
                data={data.length ? data : [{ bodyPart: "biceps", intensity: 0,  }]} // fallback to avoid crash
                type="front"
                highlightColor="red"
                style={{ width: 250, height: 400 }}
            />
        </div>
    );
}

export default function Exercise({ exercise }) {
    const [collapsed, setCollapsed] = useState(true);
    const [isEdit, setEdit] = useState(false);

    const onEditClick = () => {
        setEdit(!isEdit);
    }

    function ThisButton({ text, color }) {
        return <Button text={text} style={color + " px-8 py-1"} onClick={onEditClick} />;
    }


    return (
        <div className="border border-gray-400 rounded-lg p-3 mb-3 bg-white shadow-sm">
            <div
                className="flex items-center cursor-pointer select-none"
                onClick={() => setCollapsed(!collapsed)}
            >
                {collapsed ? (
                    <ChevronRight className="w-5 h-5 mr-2" />
                ) : (
                    <ChevronDown className="w-5 h-5 mr-2" />
                )}
                <p className="font-semibold text-lg">{exercise.name}</p>
            </div>

            {!collapsed && (
                <div className="mt-3 ml-7 text-gray-700">
                    <ExerciseDetails exercise={exercise} />

                    <div className="mt-6 flex">
                        <ThisButton text={isEdit ? "Save" : "Edit"} color={isEdit ? "bg-yellow-500" : "bg-green-600"} />
                        <Button text="Delete" style="bg-red-600 px-8 py-1 ml-5" />
                    </div>
                </div>
            )}



        </div>
    );
}
