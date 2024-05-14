import ProgressBar from "progressbar.js";
import React, { useEffect } from "react";
import { styled } from "styled-components";

const ProgressLine = styled.div`
  width: 100%;
  height: 20px;
`;

export const ProgressBarComponent = (props: { procent: number, id: string }) => {
  useEffect(() => {
    const container = document.getElementById(props.id);
    if (container) {
      if (!container.hasChildNodes()) {
        var bar = new ProgressBar.Line(container, {
          strokeWidth: 4,
          easing: 'easeInOut',
          duration: 1400,
          color: '#00b415',
          trailColor: '#eee',
          trailWidth: 4,
          svgStyle: { width: '100%', height: '100%' },
          text: {
            style: {
              color: '#999',
              position: 'absolute',
              right: '0',
              top: '60px',
              padding: 0,
              margin: 0,
              transform: null
            },
            autoStyleContainer: false
          },
          from: { color: '#ff0000' },
          to: { color: '#00b415' },
          step: (state: any, bar: any) => {
            bar.setText(Math.round(bar.value() * 100) + ' %');
          }
        });

        bar.animate(props.procent)
      }
    }
  }, [props.procent, props.id])
  return (
    <div id={props.id}></div>
  );
};
