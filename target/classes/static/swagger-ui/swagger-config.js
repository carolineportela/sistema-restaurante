window.onload = function () {
    window.ui = SwaggerUIBundle({
        url: "/v3/api-docs",
        dom_id: '#swagger-ui',
        presets: [
            SwaggerUIBundle.presets.apis,
            SwaggerUIBundle.SwaggerUIStandalonePreset
        ],
        layout: "BaseLayout",
        deepLinking: true
    });

    // Força o modo escuro
    const darkThemeStyle = document.createElement('style');
    darkThemeStyle.innerHTML = `
    body {
      background-color: #121212 !important;
      color: #fff !important;
    }
    .swagger-ui .topbar, .swagger-ui .info, .swagger-ui .scheme-container, .swagger-ui .opblock, .swagger-ui .response-col_description {
      background-color: #1f1f1f !important;
      color: #e0e0e0 !important;
    }
    .swagger-ui .opblock-tag {
      background-color: #2c2c2c !important;
      color: #fff !important;
    }
    .swagger-ui .opblock-summary {
      background-color: #333 !important;
      color: #fff !important;
    }
    .swagger-ui .opblock-description-wrapper, .swagger-ui .responses-wrapper {
      background-color: #1e1e1e !important;
      color: #fff !important;
    }
    .swagger-ui .btn {
      background-color: #333 !important;
      color: #fff !important;
    }
  `;
    document.head.appendChild(darkThemeStyle);
}
