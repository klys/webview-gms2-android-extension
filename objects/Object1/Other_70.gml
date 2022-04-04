/// @description Insert description here
// You can write your code in this editor
var type = async_load[? "type"];

if (type == "finished")
{
    array_push(outcome, "value1: " + string(async_load[? "argument0"]) + ", ");
    array_push(outcome, "value2: " + string(async_load[? "argument1"]));
}