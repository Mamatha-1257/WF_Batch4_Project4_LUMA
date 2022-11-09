import "./Button.css";
export const Button = (props) => {
  return (
    <button
      className={"btn-primary " + props.className}
      onClick={props.onClick}
    >
      {props.text}
    </button>
  );
};
